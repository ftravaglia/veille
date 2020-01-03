provider "aws" {
  profile = "default"
  region  = "eu-west-3"
}

resource "aws_default_vpc" "default" {
  tags = {
    Name = "Default VPC"
  }
}

resource "aws_security_group" "allow_ssh" {
  name        = "allow_ssh"
  description = "Allow SSH inbound traffic"
  vpc_id      = aws_default_vpc.default.id

  ingress {
    from_port   = 22
    to_port     = 22
    protocol    = "tcp"
    cidr_blocks = ["0.0.0.0/0"] # Allow all incomming trafic ... pas bien ...

  }
  tags = {
    Name = "allow_all"
  }
}

resource "aws_instance" "tp_terraform" {
  ami           = "ami-0652eb0db9b20aeaf"
  instance_type = "t2.micro"
  associate_public_ip_address = true
  key_name = "traf-docker-ec2"
  vpc_security_group_ids = [aws_security_group.allow_ssh.id]
  tags = {
    Name = "traf-aws-docker"
  }
}

