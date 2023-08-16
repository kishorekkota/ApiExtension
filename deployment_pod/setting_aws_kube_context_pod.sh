#!/bin/zsh

aws sts get-caller-identity

aws eks --region us-east-1  update-kubeconfig --name test-cluster-api-ext1

kubectl create namespace gbp-pod-tenant-namespace

kubectl config set-context --current --namespace=gbp-pod-tenant-namespace

aws ecr-public create-repository  --repository-name tenant  --region us-east-1

aws ecr-public create-repository  --repository-name financial-ext-api  --region us-east-1