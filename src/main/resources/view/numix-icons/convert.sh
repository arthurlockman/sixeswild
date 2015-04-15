#!/bin/bash

FILES=~/Downloads/128x128/*
SUFF=svg
suff=png
for f in $FILES
do
    echo "Processing $f file..."
    convert -background none $f back-button-icon.png ${f%.$SUFF}.$suff 
done

