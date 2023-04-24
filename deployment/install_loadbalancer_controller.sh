clustername='test-cluster-api-ext1'
eksctl utils associate-iam-oidc-provider --region us-east-1 --cluster $clustername --approve
aws sts get-caller-identity
aws eks update-kubeconfig --region us-east-1  --name $clustername


curl -o /tmp/iam_policy.json https://raw.githubusercontent.com/kubernetes-sigs/aws-load-balancer-controller/main/docs/install/iam_policy.json

aws iam create-policy --policy-name AWSLoadBalancerControllerIAMPolicy --policy-document file:///tmp/iam_policy.json

eksctl create iamserviceaccount --cluster $clustername --namespace kube-system --name aws-load-balancer-controller --attach-policy-arn arn:aws:iam::593393184947:policy/AWSLoadBalancerControllerIAMPolicy --override-existing-serviceaccounts --approve


{
helm repo add eks https://aws.github.io/eks-charts
helm repo update
}

kubectl get sa aws-load-balancer-controller -n kube-system -o yaml


{
VPC_ID=$(aws eks describe-cluster \
--name $clustername \
--query "cluster.resourcesVpcConfig.vpcId" \
--output text)
echo $VPC_ID
}

kubectl apply -k "github.com/aws/eks-charts/stable/aws-load-balancer-controller/crds?ref=master"

helm install \
aws-load-balancer-controller \
eks/aws-load-balancer-controller \
-n kube-system \
--set clusterName=$clustername \
--set serviceAccount.create=false \
--set serviceAccount.name=aws-load-balancer-controller \
--set image.tag=v2.4.2 \
--set region=us-east-1 \
--set vpcId=${VPC_ID} \
--version=1.4.3

