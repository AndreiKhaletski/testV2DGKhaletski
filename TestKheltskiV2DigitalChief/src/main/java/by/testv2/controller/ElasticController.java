package by.testv2.controller;

import by.testv2.service.ElasticService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class ElasticController {

    private final ElasticService elasticService;

    public ElasticController(ElasticService elasticService) {
        this.elasticService = elasticService;
    }

    @GetMapping("/load")
    public ResponseEntity<String> load() throws IOException {
        elasticService.loadProducts();
        return ResponseEntity.ok("Данные загружены в Elasticsearch");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Map<String, Object>>> search(@RequestParam String keyword) throws IOException {
        List<Map<String, Object>> searchResults = elasticService.searchProducts(keyword);
        return ResponseEntity.ok(searchResults);
    }
}
