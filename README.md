# ApiExtension

POC for trying out API Extension for injecting additional behavior during API transaction processing.

### Main Application

This is under root folder, accepts payload with combination of define and undefined sections.

Undefined section is accepted as a JSON Payload and JsonNode type was used in POJO.



### Injecting Behavior via second app.

Second APP EXTAccountAPI.

Second APP has a predefined API Structure which allows Main App to trigger API calls to execute additional behavior.

Key API interaction included in this are.

- Pre_Execution
- Post_Execution

### Deployment Model

- Options#1) Second App can be deployed as a SideCar running in the same POD as the first one. This minimizes any network overhead included with running as a standalone app.

- Options#2) Second App will be running in a seperate POD. This model can launch Second App in a POD that is running in same Kuberenetes Node or someother node. Depending on POD running in same node or else where, this add additional latency to the API Execution.


### How to run ?

Both application are built using Spring Boot.

Second application is running in Port 8082.

Folder `deployment` has Kube Deployment Config for Deployment, Service and Ingress. 

(To Be Worked)Folder `deployment_pod` has Kube Deployment Config for Deployment, Service and Ingress for POD based connectivity.


