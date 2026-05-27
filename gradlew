#!/usr/bin/env sh

#
# Copyright 2015 the original author or authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

##############################################################################
##
##  Gradle start up script for UN*X
##
##############################################################################

# Attempt to set APP_HOME
# Resolve links: $0 may be a symlink
prog="$0"
# Need this for relative symlinks.
while [ -h "$prog" ] ; do
    ls=`ls -ld "$prog"`
    link=`expr "$ls" : '.*-> \(.*\)$'`
    if expr "$link" : '/.*' > /dev/null; then
        prog="$link"
    else
        prog=`dirname "$prog"`"/$link"
    fi
done
savedir=`pwd`
cd "`dirname \"$prog\"`" >/dev/null
app_home=`pwd -P`
cd "$savedir" >/dev/null

APP_HOME=$( cd "${APP_HOME:-./}" && pwd -P ) || exit

APP_NAME="Gradle"
APP_BASE_NAME=`basename "$0"`

# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='" -Xmx64m" "-Xms64m"'

# Use the maximum available, or set MAX_FD != infinity.
if ! expr "$MAX_FD" : '[0-9]\\+$' > /dev/null; then
    MAX_FD=maximum
fi

# Warning in case JAVA_HOME is not set.
if [ ! -d "$JAVA_HOME" ] ; then
    echo "Warning: JAVA_HOME environment variable is not set."
fi

READLINK=readlink
if ! command -v $READLINK >/dev/null; then
    READLINK=realpath
fi

if ! command -v $READLINK >/dev/null; then
    READLINK=realpath
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if case "$( uname )" in
      CYGWIN*|MSYS*)
        echo "true"
        ;;
esac then
    # attempt to get the real path
    # for symlinks that resolve to UNC paths on windows
    START_ESCAPED=`$READLINK -f \"$START\" 2>/dev/null`
    if [ $? -eq 0 ]; then
        START_ESCAPED="`$READLINK -f \"$START\""`
    else
        START_ESCAPED="\"$START\""
    fi
    JAVA_HOME_ESCAPED="`$READLINK -f \"$JAVA_HOME\" 2>/dev/null`
    if [ $? -eq 0 ]; then
        JAVA_HOME_ESCAPED="`$READLINK -f \"$JAVA_HOME\""`
    else
        JAVA_HOME_ESCAPED="\"$JAVA_HOME\""
    fi
    NEW_BASE_PATH="`$READLINK -f \"$APP_HOME\" 2>/dev/null`
    if [ $? -eq 0 ]; then
        NEW_BASE_PATH="`$READLINK -f \"$APP_HOME\""`
    else
        NEW_BASE_PATH="\"$APP_HOME\""
    fi
    START="$START_ESCAPED"
    JAVA_HOME="$JAVA_HOME_ESCAPED"
    APP_HOME="$NEW_BASE_PATH"
    # add a user-defined append to CLASS_PATH in the falling var
        # CLASS_PATH also contains APP_HOME
    CLASS_PATH="$APP_HOME/gradle/wrapper/gradle-wrapper.jar"
else
    # For regular Un*x systems, that usually means the directories are standard.
    CLASS_PATH=$APP_HOME/gradle/wrapper/gradle-wrapper.jar
fi

# Determine the Java command to use in order to perform the actual submission.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD=$JAVA_HOME/jre/sh/java
    else
        JAVACMD=$JAVA_HOME/bin/java
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD=java
    which java >/dev/null 2>&1 || die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$msys" ; then
    MAX_FD_LIMIT=`ulimit -H -n`
    if [ $? -eq 0 ] ; then
        if [ "$MAX_FD" = "maximum" -o "$MAX_FD" = "max" ] ; then
            MAX_FD=$MAX_FD_LIMIT
        fi
        ulimit -n $MAX_FD
        if [ $? -ne 0 ] ; then
            warn "Could not set maximum file descriptor limit: $MAX_FD"
        fi
    else
        warn "Could not query maximum file descriptor limit: $MAX_FD_LIMIT"
    fi
fi

# For Darwin, add options to specify how the application appears in the dock
if "$darwin"; then
    GRADLE_OPTS="$GRADLE_OPTS \"-Xdock:name=$APP_NAME\" \"-Xdock:icon=$APP_HOME/media/gradle.icns\""
fi

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=`cygpath --path --mixed "$APP_HOME"`
    CLASSPATH=`cygpath --path --mixed "$CLASSPATH"`

    JAVACMD=`cygpath --unix "$JAVACMD"`

    # We build the pattern for arguments to be converted via cygpath
    ROOTDIRSRAW=`find -L / -maxdepth 3 -type d -name gradle 2>/dev/null`
    SEP=""
    for dir in $ROOTDIRSRAW ; do
        ROOTDIRS="$ROOTDIRS$SEP$dir"
        SEP=|  
    done
    OURCYGPATTERN="(^($ROOTDIRS))"
    # Add a user-defined append to CLASS_PATH in the falling var
    # CLASS_PATH also contains APP_HOME
    classpatharg=`cygpath --path --mixed "$CLASS_PATH"`
    CLASSPATH="$classpatharg"

    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    i=0
    for arg in "$@" ; do
        CHECK=`echo "$arg"|egrep -c "^-"`                                 # check if it is an option
        if [ $CHECK -eq 1 -a "$i" -ne 0 ] ; then                          # if it is an option and it's not the first arg
            arg=`cygpath --path --windows "$arg"`                         # convert to windows path
        fi
        ARGS="$ARGS \"$arg\""
        i=`expr $i + 1`
    done
fi

# Collect all arguments for the java command, stacking in reverse order:
#   * args from the command line
#   * the main class name
#   * -classpath
#   * -D...appname settings
#   * --module-path (only if needed)
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and GRADLE_OPTS environment variables.

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    # Save all arguments for later
    declare -a arguments=("$@")
fi

echo locate base dir as "$APP_HOME"
echo starting gradle

APP_ARGS=""
for arg in "$@" ; do
    ARGS="$ARGS \"$arg\""
done

# Collect all arguments for the java command
eval set -- $DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS -classpath "$CLASS_PATH" org.gradle.wrapper.GradleWrapperMain "$@"

exec "$JAVACMD" "$@"
