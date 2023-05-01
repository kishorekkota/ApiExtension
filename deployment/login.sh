#!/bin/zsh
# Description: Login to the sandbox
~/apps/pcl/pcl aws --sandbox-user --domain naeast  --sid N783050

export AWS_DEFAULT_PROFILE=adfs

aws ecr-public get-login-password --region us-east-1 | docker login --username AWS --password-stdin public.ecr.aws/norse
