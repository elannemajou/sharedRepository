package fr.chronopost.xmlfilereader

import groovy.io.FileType

class ReadStrutsConfigFile {
	
	public static String filterFileContent(file){
		List lines = file.readLines()
		lines.remove(0)
		lines.remove(0)
		return lines.join("\n")
	}
	
	
	public static String parseAFile(String content, String category){
		def records = new XmlSlurper().parseText(content)
		def result =""
		def allRecords = records.children().action
		allRecords.each {
			result = result + "\n;${category};" 
			result = result + "${it.@path.text()};"
			def forwards = it.forward
			forwards.each {forward ->
				if (forward.@path.text().contains(".jsp")){
					if (forward.@path.text().contains("?p=")){
						def filepath = forward.@path.text().replace("?p=", ";")
						result = result + "${filepath} [${forward.@name.text()}];"
					}else{
						result = result + "${forward.@path.text()} [${forward.@name.text()}];"
					}
				}
			}
		}	
		return result?.replaceAll("(?m)^[ \t]*\r?\n", "")
	}
	
	public static Integer readAndCountDifferentJsp(File file){
		List lines = file.readLines()
		Set<String> resultSet = new HashSet<String>()
		lines.each{String line ->
			if (line.contains(".jsp")){
				String[] jspArray = line.split(";")
				for (int i=0; i < jspArray.length; i++){
					if (jspArray[i].contains("jsp") && !resultSet.contains(jspArray[i])){
						resultSet.add(jspArray[i])
						print "${jspArray[i]}\n"
					}
				}
			}
		}
		return resultSet.size()
	}
	
	public static Set<String> readAndCheckIfUsedJsp(File file, File targetFile){
		List lines = file.readLines()
		Set<String> resultSet = new HashSet<String>()
		lines.each{String line ->
			if (line.contains(".jsp")){
				String[] jspArray = line.split(";")
				for (int i=0; i < jspArray.length; i++){
					if (jspArray[i].contains("jsp") && !resultSet.contains(jspArray[i])){
						List targetLines = targetFile.readLines()
						/* check if jsp is in target file */
						String modifiedPage = jspArray[i].substring(jspArray[i].lastIndexOf('/') + 1, jspArray[i].lastIndexOf("jsp") + 3)
						if (!targetLines?.get(0).contains(modifiedPage)){
							resultSet.add(jspArray[i])
						}
						//print "${jspArray[i]}\n"
					}
				}
			}
		}
		return resultSet
	}
	
	

	static main(args) {
		String baseDir = "C:\\Users\\elannemajou\\Desktop\\AppliConfigJsp"
		String category = "CHRONOTRACE_V3"
		def dir = new File("${baseDir}\\${category}\\sources")
		File resultFile = new File("${baseDir}\\${category}\\${category}_Result.csv")
		File targetFile = new File("${baseDir}\\jspEQUALLIA.txt")
		File diffFile = new File("${baseDir}\\${category}\\diff.txt")
		dir.eachFile{ File file ->
			def content = parseAFile(filterFileContent(file), category)
			print content
			resultFile << "\n ${file.name};\n" 
			resultFile << content
		}
		resultFile << " \n total number of different jsp is : ${readAndCountDifferentJsp(resultFile)}"
		Set<String> resultSet = readAndCheckIfUsedJsp(resultFile, targetFile)
		resultSet.each {
			diffFile << "${it} \n "	
		}
	}
}
