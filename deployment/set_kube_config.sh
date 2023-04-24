#!/bin/zsh

aws eks --region us-east-1  update-kubeconfig --name test-cluster-api-ext
kubectl create namespace eks-sample-app
kubectl config set-context --current --namespace=eks-sample-app