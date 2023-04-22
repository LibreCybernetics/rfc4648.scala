{
  description = "LibreCybernetics Monorepo Flake";

  inputs.devshell.url    = "github:numtide/devshell";
  inputs.flake-utils.url = "github:numtide/flake-utils";

  outputs = { self, nixpkgs, devshell, flake-utils }:
    flake-utils.lib.eachDefaultSystem (system:
      let
        pkgs = import nixpkgs {
          inherit system;

          overlays = [ devshell.overlays.default ];
        };
        jdk = pkgs.jdk11;
      in rec {
        config = {
          env = [{
            name = "JAVA_HOME";
            value = "${jdk.home}";
          }];
          
          packages = with pkgs;[
            stdenv.cc
            bazel_6
            jdk
          ];
        };

        devShell = pkgs.devshell.mkShell {
          env = config.env;
          packages = config.packages;
        };
      }
    );
}
