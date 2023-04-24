kubectl create namespace eks-sample-app
kubectl apply -f deployment.yaml
kubectl apply -f service.yaml
kubectl apply -f Ingress.yaml