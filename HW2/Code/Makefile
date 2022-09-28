merge:
		@echo "Merging files into 'mergedFile.csv' ..."
		javac Merge.java; java Merge ./data/mergedFile.csv ./data/Kickstarter1.csv ./data/Kickstarter2.csv ./data/Kickstarter3.csv

search:
		javac Search.java; java Search ./data/mergedFile.csv $(inputSearch)
		@echo "Searching String $(inputSearch) in file ... Done."

history:
		@echo "History of User Input..."
		javac History.java; java History $(inputSearch)

clean:
		@echo "Cleaning Up..."
		rm ./*.class
		rm ./.history