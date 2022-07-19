# create docker image
#
# Usage:
#   docker_build.sh
#
# Parameter:
#   none
#
# Return:
#   0: success
#   1: failed
#

VERSION=1.0.1
IMAGE_NAME="docker-image-test-springboot":$VERSION
CONTAINER_NAME="test-springboot-docker-container"
REPOSITORY_URL="https://github.com/wangliang0585/test-springboot.git"


# First, git clone repository
git clone $REPOSITORY_URL
cd test-springboot
mvn install package -DskipTests

# Second, docker build image
docker build -t $IMAGE_NAME .

#docker stop and remove container if exist
OLD="$(docker ps --all --quiet --filter=name="$CONTAINER_NAME")"
if [ -n "$OLD" ]; then
  docker stop "$OLD" && docker rm "$OLD"
fi

#docker stop $CONTAINER_NAME
#docker rm $CONTAINER_NAME

# Third, run docker container
docker run -d -p 8080:9090 --name $CONTAINER_NAME $IMAGE_NAME
#docker ps -a
docker logs $CONTAINER_NAME
# return 0
#exit 0


