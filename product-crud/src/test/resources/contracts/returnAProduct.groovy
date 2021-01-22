package contracts

import org.springframework.cloud.contract.spec.Contract

Contract.make{
    description "return the 1st product"
    request {
        method GET()
        url("/products"){
            queryParameters {
                parameter("id", "1")
            }
        }
    }
    response {
        status 200
    }
}
