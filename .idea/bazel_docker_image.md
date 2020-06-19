## Setting up Working Environment with Docker

ZetaSQL requires bazel version 1.0.0 installed. An easy way to prevent workspace compatibility issues is to
create a fresh environment with [docker](https://docs.docker.com/get-docker/)

After installing docker you need to copy this [Dockerfile](https://github.com/orhanuysal/testest/blob/master/.idea/Dockerfile)
to your workspace. It will configure building.
Then you can create docker image with running this command *in your workspace*:

``docker build -t bazelimage .``

Make sure Docker Desktop is running to be able to use `docker` commands. Now, an operating system capable of building zetasql
is created with name `bazelimage`. Now you can run:

```docker run -it -v "$PWD":/source --rm --entrypoint=/bin/bash bazelimage```

This command will run this OS on your workspace. Your workspace will be available in `//source` folder. The `//source` folder
in bazel image and your workspace in your computer will share the same memory space, i.e. Any changes you made in
your workspace will be available on bazel image.
