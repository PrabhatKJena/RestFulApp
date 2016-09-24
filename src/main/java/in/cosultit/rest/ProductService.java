package in.cosultit.rest;

import in.consultit.model.Product;
import in.consultit.model.ProductResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

@Path("/productSvc")
public class ProductService {

   /* @GET
    @Path("/{param}")
    public Response getMsg(@PathParam("param") String msg) {
        String output = "Jersey say : " + msg;
        return Response.status(200).entity(output).build();

    }*/

    @GET
    @Path("/findProduct/{productId}")
    @Produces({MediaType.APPLICATION_XML})
    public Response findProduct(@PathParam("productId") String productId) {
        ProductResponse response = new ProductResponse();
        List<Product> list = findById(productId);
        response.setProductList(list);
        return Response.ok().entity(response).build();
    }

    private List<Product> findById(String productId) {
        List<Product> result = new ArrayList<Product>();
        for (Product p : list) {
            if (productId.equalsIgnoreCase(p.getProductId())) {
                result.add(p);
            }
        }
        return result;
    }

    static List<Product> list;

    static {
        list = new ArrayList<Product>();
        Product p = new Product();
        p.setPrice(1000d);
        p.setProductId("P001");
        p.setProductType("FOOD");
        p.setStatus("Available");
        list.add(p);

        p = new Product();
        p.setPrice(300d);
        p.setProductId("P002");
        p.setProductType("Stationary");
        p.setStatus("Available");
        list.add(p);

        p = new Product();
        p.setPrice(133d);
        p.setProductId("P003");
        p.setProductType("Cosmetics");
        p.setStatus("Not Available");
        list.add(p);

        p = new Product();
        p.setPrice(200d);
        p.setProductId("P004");
        p.setProductType("Stationary");
        p.setStatus("Available");
        list.add(p);
    }


}