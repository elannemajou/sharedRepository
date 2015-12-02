package fr.chronopost.jspfilereader

import java.io.File;

class JspXitifileFormatter {

	static boolean formatFile(File fileSrc, File targetFile){
		List lines = fileSrc.readLines()
		boolean isToRemove = false
		boolean isFormatted = false
		for (int i = 0; i < lines.size(); i++){
			String lineToDisplay = lines[i]
			if (lines[i].contains("<!-- Marqueur Xiti -->")){
				lineToDisplay = lines[i].replace("<!-- Marqueur Xiti -->", "<!-- Marqueur Xiti -->\n<!-- Refonte XITI -->\n<!-- .Marqueur Xiti -->")
				isToRemove = true
				if (!isFormatted){
					isFormatted = true
				}
			}
			if (lines[i].contains("<!-- .Marqueur Xiti -->")){
				lineToDisplay = lines[i].replace("<!-- .Marqueur Xiti -->", "")
				isToRemove = false
			}

			if (!lineToDisplay.equals("") && (lineToDisplay.contains("Marqueur Xiti") || lineToDisplay.contains("Refonte XITI") || !isToRemove )){
				targetFile << lineToDisplay
				//print lines[i]
				//print "\n"
				targetFile << "\n"
			}
		}
		return isFormatted
	}
	

	static boolean addCustomTagLib(File fileSrc, File targetFile){
		List lines = fileSrc.readLines()
		String customTagToAdd = "\n<%@ taglib uri=\"/META-INF/ex.tld\" prefix=\"ex\"%>"
		boolean isFormatted = false
		
		for (int i = 0; i < lines.size(); i++){
			
			String lineToDisplay = lines[i]
			isFormatted = lineToDisplay.contains(customTagToAdd)
			
			if ( i == 3 && !isFormatted){
				lineToDisplay = lines[i] + customTagToAdd
				isFormatted = true
			}
			
			if (!lineToDisplay.equals("")){
				targetFile << lineToDisplay
				//print lines[i]
				//print "\n"
				targetFile << "\n"
			}
		}
		return isFormatted
	}
	
	
	static void formatDir(File fileSrc, String basePath){
		new File(basePath).mkdir()
		fileSrc.eachFile{ File file ->
			if (file.file){
				String name = file.canonicalPath
				if (file.canonicalPath.contains('.')){
					name = name.substring(0, file.canonicalPath.lastIndexOf('.'))
				}
				String suffix = file.name.substring(file.name.lastIndexOf('.')+1)
				if (file.name.contains("jsp")){
					File newFile = new File("${basePath}\\${file.name}.tmp")
					if (!formatFile(file, newFile)){
						file.delete()
					}else {
						addCustomTagLib(newFile, new File("${basePath}\\${file.name}"))
						print "formatted file :  ${file} \n"
					}
					newFile.delete()
				}
			}else{
				formatDir(file, "${basePath}\\${file.name}")
			}
		}
}
	
	
	static main(args) {
		print "start format jsp \n"
		String baseDir = "C:\\Users\\elannemajou\\Desktop\\AppliFormatXitiJsp"
		String category = "WEB_ACCOUNT"
		def dir = new File("${baseDir}\\${category}\\sources")
		formatDir(dir,"${baseDir}\\${category}\\target")
		print "end format jsp \n"
	}
	
}
