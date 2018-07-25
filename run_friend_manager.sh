docker build --no-cache -t friend_manager_docker_image .
docker run --rm -d -p 8080:8080 -t friend_manager_docker_image:latest
docker_ip=$(docker-machine ls)
echo "\033[1mFriend manager has started successfully on http://$docker_ip:8080\033[0m"
