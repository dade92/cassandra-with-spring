cd local-env
docker compose up -d cassandra
echo "Waiting for cassandra to be up and running..."
sleep 60
docker compose up -d cassandra-load-keyspace
echo "Initializing cassandra db..."
docker ps
echo "Everything should be up and running now!"