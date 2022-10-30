#!/bin/sh
find . -mtime -1 -type f -print | xargs ls -ltr > Files_Created_Today.txt
