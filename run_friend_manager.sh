docker build --no-cache -t friend_manager_docker_image .
docker run --rm -d -p 8080:8080 -t friend_manager_docker_image:latest
docker_ip=$(docker-machine ip)
echo $(tput bold)$(tput setaf 2)Friend manager has started successfully on http://192.168.99.100:8080$(tput sgr0)
