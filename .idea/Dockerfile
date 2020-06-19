FROM ubuntu:18.04

# Avoid warnings by switching to noninteractive
ENV DEBIAN_FRONTEND=noninteractive

# Configure apt and install packages
RUN apt-get update \
    && apt-get -y install --no-install-recommends apt-utils dialog 2>&1 \
    # 
    # Verify git, process tools, lsb-release (useful for CLI installs) installed
    && apt-get -y install git procps lsb-release \
    #
    && apt-get -y install pkg-config zip g++ zlib1g-dev unzip python python3-distutils wget bash-completion openjdk-11-jdk-headless tzdata

RUN wget "https://github.com/bazelbuild/bazel/releases/download/1.0.0/bazel-1.0.0-installer-linux-x86_64.sh"
RUN chmod +x bazel-1.0.0-installer-linux-x86_64.sh && ./bazel-1.0.0-installer-linux-x86_64.sh --user
RUN echo 'export PATH="$PATH:$HOME/bin"' >>~/.bashrc
