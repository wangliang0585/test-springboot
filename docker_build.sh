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

docker build -t docker-image-test-springboot .
docker run -d -p 8080:9090 --name test-springboot docker-image-test-springboot
docker ps -a
docker logs test-springboot
# return 0
exit 0


