package tunas.ecomerce.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tunas.ecomerce.cutomresponse.CustomResponse;
import tunas.ecomerce.cutomresponse.ListResponse;
import tunas.ecomerce.cutomresponse.ObjectResponse;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/{id}")
    public ObjectResponse<Customer> getCustomer(@PathVariable UUID id){
        Customer customer = customerService.getCustomer(id);
        CustomResponse<Customer> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(customer, HttpStatus.OK);
    }

    @GetMapping
    public ListResponse<List<Customer>> getAllCustomers(){
        List<Customer> customers = customerService.getCustomers();
        CustomResponse<Customer> customResponse = new CustomResponse<>();
        return customResponse.sendResponse(customers,HttpStatus.OK);
    }

    @PostMapping
    public ObjectResponse<String> saveCustomer(@RequestBody Customer customer){
        System.out.println(customer);
        customerService.saveCustomer(customer);
        CustomResponse<String> customResponse = new CustomResponse<>();
        return customResponse.sendResponse("",HttpStatus.CREATED);
    }
}
