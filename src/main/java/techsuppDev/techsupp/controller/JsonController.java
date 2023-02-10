package techsuppDev.techsupp.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import techsuppDev.techsupp.domain.Product;
import techsuppDev.techsupp.service.ProductService;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class JsonController {


    private final ProductService productService;
    //    api controller
    // db에서 검색해서 json 형식으로 client 에게 보내주기 성공
    @GetMapping("/api")
    @ResponseBody
    public List<Product> apiSend() {
        List<Product> products = productService.findAllProduct();
        return products;
    }

//    일단은 5개 가져오는거 성공
//    페이지에 따라서 보내주는 데이터 식별 필요
    @GetMapping("/productMain/{productPageNumber}")
    @ResponseBody
    public List<Product> productFiveSend(@PathVariable("productPageNumber") Long id) {
        List<Product> fiveProduct = productService.findFiveProduct(id);
        return fiveProduct;
    }


//    페이징 용 id값 전부 가져오기
    @GetMapping("/productMain/paging")
    @ResponseBody
    public Object numberOfProductsSend() {
        return productService.getNumberOfProduct();
    }





    // js function에서 url로 검색하는 것 성송
//    서칭할때 저거를 기준으로 저거를 기준으로 서칭하면 됨

//    @GetMapping("/api/{productNumber}")
//    @ResponseBody
//    public Product productOneSend(@PathVariable("productNumber") Long id) {
//        Product oneProduct = productService.findOneProduct(id);
//        return oneProduct;
//    }
}