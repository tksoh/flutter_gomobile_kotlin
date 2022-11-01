#!sh

ROOTDIR="$(git rev-parse --show-toplevel)"
LIBDIR=$ROOTDIR/android/app/src/main/libs/

mkdir -p $LIBDIR
cd $ROOTDIR/gomobilelib
gomobile bind --target android && cp gomobilelib.aar $LIBDIR
