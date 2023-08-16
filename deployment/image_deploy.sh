#!/bin/bash
set -e
set -x
set -u
VERSION=1.4.7



echo "Building Accounts API"

cd /Users/kishorekota/git/ApiExtension/DepositsAccountAPI
./gradlew bootBuildImage  --imageName="docker.io/kishorekkota/financial-ext-api:"$VERSION
cd /Users/kishorekota/git/ApiExtension/
./gradlew bootBuildImage  --imageName="docker.io/kishorekkota/gbp-core-api:"$VERSION

docker tag kishorekkota/gbp-core-api:$VERSION public.ecr.aws/norse/gbp-core-api:$VERSION

docker tag kishorekkota/financial-ext-api:$VERSION public.ecr.aws/norse/financial-ext-api:$VERSION


docker push public.ecr.aws/norse/gbp-core-api:$VERSION

docker push public.ecr.aws/norse/financial-ext-api:$VERSION