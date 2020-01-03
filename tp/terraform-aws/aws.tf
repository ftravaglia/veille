provider "aws" {
  profile = "default"
  region  = "eu-west-3"
}

resource "aws_instance" "tp_terraform" {
  ami           = "ami-0652eb0db9b20aeaf"
  instance_type = "t2.micro"
  associate_public_ip_address = true
  key_name = "traf-docker-ec2"
  tags = {
    Name = "traf-aws-docker"
  }
}

