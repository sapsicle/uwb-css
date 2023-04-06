#!/bin/bash

# To more easily compile and run this program on CSS Linux Lab
# Lines starting with '$' indicate what is typed on command line

# if you get the following error:
# -bash: ./simplecompile.sh: /bin/bash^M: bad interpreter: No such file or directory
# run dos2unix to fix it
# $ dos2unix simplecompile.sh

# make this file executable
# $ chmod 700 simplecompile.sh
# redirect the output and stderr from this file to output.txt
# $ ./simplecompile.sh > output.txt 2>&1


date

echo "*** compiling with clang++ to create an executable called assignment1"
clang++ --version
clang++ -std=c++14 -Wall -Wextra -Wno-sign-compare *.cpp -g -o assignment1

echo "*** running clang-tidy using options from .clang-tidy"
clang-tidy --version
clang-tidy *.cpp -- -std=c++15

echo "*** running assignment1"
./assignment1

# valgrind will detect memory leaks
# echo "*** running with valgrind"
# valgrind ./assignment1.exe

echo "*** cleaning up, deleting assignment1"
rm assignment1

date