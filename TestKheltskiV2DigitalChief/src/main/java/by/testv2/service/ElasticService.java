package by.testv2.service;

import by.testv2.core.entity.ProductEntity;
import by.testv2.dao.ProductResource;
import by.testv2.service.api.IElasticService;
import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch.core.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ElasticService implements IElasticService {

    private final ProductResource productResource;
    private final ElasticsearchClient elasticsearchClient;
    private final ObjectMapper objectMapper;

    public ElasticService(ProductResource productResource, ElasticsearchClient elasticsearchClient, ObjectMapper objectMapper) {
        this.productResource = productResource;
        this.elasticsearchClient = elasticsearchClient;
        this.objectMapper = objectMapper;
    }

    @Override
    public void loadProducts() throws IOException {
        boolean indexExists = elasticsearchClient.indices().exists(e -> e.index("products")).value();
        if (!indexExists) {
            elasticsearchClient.indices().create(c -> c.index("products"));
        }

        ProductEntity product = new ProductEntity(1L, "Car", "car", true, LocalDate.now(), Collections.emptyList());

        Map<String, Object> productMap = objectMapper.convertValue(product, Map.class);

        IndexResponse response = elasticsearchClient.index(i -> i
            .index("products")
            .id(product.getId().toString())
            .document(productMap)
        );

        System.out.println("Indexed with version " + response.version());
    }

    @Override
    public List searchProducts(String keyword) throws IOException {
        SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s
            .index("products")
            .query(q -> q
                .multiMatch(m -> m
                    .query(keyword)
                    .fields("name", "description")
                )
            ), Map.class);

        return searchResponse.hits().hits().stream()
            .map(hit -> hit.source())
            .collect(Collectors.toList());
    }

}
