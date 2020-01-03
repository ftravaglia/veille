resource "docker_container" "filebeat-tf" {
  image = "docker.elastic.co/beats/filebeat:7.4.2"
  name = "filebeat-host"
  user = "root"
  network_mode = "host"
  command = ["--strict.perms=false"]
  
  volumes {
     host_path = "/home/ftravaglia/work/docker/beats/filebeats/filebeat.yml"
     container_path = "/usr/share/filebeat/filebeat.yml"
     read_only = true
  }
  volumes {
     host_path = "/var/lib/docker/containers"
     container_path = "/var/lib/docker/containers"
     read_only = true
  }
  volumes {
     host_path = "/var/run/docker.sock"
     container_path = "/var/run/docker.sock"
     read_only = true
  }
  volumes {
     host_path = "/home/ftravaglia/work/logs/"
     container_path = "/usr/share/filebeat/log-host/"
     read_only = true
  }
}

resource "docker_container" "metricbeat-tf" {
  image = "docker.elastic.co/beats/metricbeat:7.4.2"
  name = "metricbeat-host"
  user = "root"
  network_mode = "host"
  command = ["--strict.perms=false"]
 
  volumes {
     host_path = "/home/ftravaglia/work/docker/beats/metricbeats/metricbeat.yml"
     container_path = "/usr/share/metricbeat/metricbeat.yml"
     read_only = true
  }
  volumes {
     host_path = "/proc"
     container_path = "/hostfs/proc"
     read_only = true
  }
  volumes {
     host_path = "/sys/fs/cgroup"
     container_path = "/hostfs/sys/fs/cgroup"
     read_only = true
  }
  volumes {
     host_path = "/"
     container_path = "/hostfs"
     read_only = true
  }
  volumes {
     host_path = "/var/run/docker.sock"
     container_path = "/var/run/docker.sock"
     read_only = true
  }

}

