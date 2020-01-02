resource "docker_network" "elk_network" {
  name = "esnet"
  driver = "bridge"
}

resource "docker_volume" "esdata1" {
  name = "esdata1"
}


resource "docker_container" "elasticsearch-tf" {
  image = "docker.elastic.co/elasticsearch/elasticsearch:7.4.2"
  name = "elasticsearch"
  env = ["discovery.type=single-node"]
  ulimit {
     name = "memlock"
     soft = -1
     hard = -1
  }
  ports {
     internal = 9200
     external = 9200
  }
  ports {
     internal = 9300
     external = 9300
  } 
  networks_advanced {
     name = "esnet"
  }
  volumes {
     volume_name = "esdata1"
     container_path = "/usr/share/elasticsearch/data"
  }
}

resource "docker_container" "logstash-tf" {
  depends_on = [docker_container.elasticsearch-tf]
  image = "docker.elastic.co/logstash/logstash:7.4.2"
  name = "logstash"
  ports {
     internal = 9600
     external = 9600
  }
  ports {
     internal = 5000
     external = 5000
  }
  ports {
     internal = 5044
     external = 5044
  }
  networks_advanced {
     name = "esnet"
  }

  volumes {
     host_path = "/home/ftravaglia/work/docker/elk/logstash-config/logstash.yml"
     container_path = "/usr/share/logstash/config/logstash.yml"
  }
  volumes {
     host_path = "/home/ftravaglia/work/docker/elk/logstash-config/logstash.conf"
     container_path = "/usr/share/logstash/pipeline/logstash.conf"
  }

}

resource "docker_container" "kibana-tf" {
  depends_on = [docker_container.logstash-tf]
  image = "docker.elastic.co/kibana/kibana:7.4.2"
  name = "kibana"

  ports {
     internal = 5601
     external = 5601
  }
  networks_advanced {
     name = "esnet"
  }

  volumes {
     host_path = "/home/ftravaglia/work/docker/elk/kibana-config/kibana.yml"
     container_path = "/usr/share/kibana/config/kibana.yml"
  }

}

