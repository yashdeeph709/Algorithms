if [ $# -ne 2 ]
then
	echo "Usage: buildJava.sh <section> <ProblemId/ProblemName>"
	exit 1 
fi
echo "Building Setup for "$1
src="src"
package="com/hackerearth/codemonk"
section=$1
problem=$2

# Create Directory if section doesn't exists
if [ ! -d $src/$package/$section ]
then
	mkdir $src/$package/$section
	echo "Section " $section " created!"
fi

if [ -f $src/$package/$section/$problem.java ]
then 
	echo $src/$package/$section/$problem.java " Already Exists"
	exit 1
fi 

touch $src/$package/$section/$problem.java
sed -e "s/\${section}/$section/" -e "s/\${programid}/$problem/" template.java >> $src/$package/$section/$problem.java
echo "javac -d bin/ $src/$package/$section/$problem.java"
echo "java -cp bin/ ${package//\//.}.$section.$problem"

#function runTest {
#	java -cp bin/ ${package//\//.}.$section.$problem < $1
#}
#function compileCode {
#	echo "javac -d bin/ $src/$package/$section/$problem.java"
#	javac -d bin/ $src/$package/$section/$problem.java
#}
