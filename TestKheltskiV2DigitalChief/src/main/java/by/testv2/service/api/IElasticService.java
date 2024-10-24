package by.testv2.service.api;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface IElasticService {

    public void loadProducts() throws IOException;

    public List<Map<String, Object>> searchProducts(String keyword) throws IOException;
}
