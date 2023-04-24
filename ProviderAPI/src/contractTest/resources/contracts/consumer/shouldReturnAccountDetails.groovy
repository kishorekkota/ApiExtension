package contracts.consumer

import org.springframework.cloud.contract.spec.Contract

Contract.make {
    description "should return account info for a given account number"
    request{
        method GET()
        url("/account/account-number") {

        }
    }
    response {
        body(
                "accountNumber" : anyNonEmptyString(),
                "accountID" : anyNonEmptyString(),
                "limitAmount" : anyNumber(),
                "ssn" : anyNonEmptyString(),
                "email" : anyEmail()
        )
        status 200
    }
}