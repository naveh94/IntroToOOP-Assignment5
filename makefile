# 312275746
# Naveh Marchoom

compile: bin
	find src -name "*.java" > sources.txt
	javac -d bin -cp biuoop-1.4.jar @sources.txt

jar:
	jar cfm ass5game.jar Manifest.mf -C bin .
run:
	java -cp biuoop-1.4.jar:bin Ass5Game
	
bin:
	mkdir bin