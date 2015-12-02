package fr.chronopost.jspfilereader

class JspfileFormatter {

	static boolean formatFile(File fileSrc, File targetFile){
		List lines = fileSrc.readLines()
		boolean isToRemove = false
		boolean isFormatted = false
		for (int i = 0; i < lines.size(); i++){
			String lineToDisplay = lines[i]
			if (lines[i].contains("<!-- refonte-add-start -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-add-start -->", "")
				if (!isFormatted){
					isFormatted = true
				}
				
			}
			if (lines[i].contains("<!-- refonte-add-stop -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-add-stop -->", "")
			}
			if (lines[i].contains("<!-- refonte-add_start -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-add_start -->", "")
				if (!isFormatted){
					isFormatted = true
				}
			}
			if (lines[i].contains("<!-- refonte-add_stop -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-add_stop -->", "")
			}
			if (lines[i].contains("<!-- refonte-remove-start -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-remove-start -->", "")
				isToRemove = true
				if (!isFormatted){
					isFormatted = true
				}
			}
			if (lines[i].contains("<!-- refonte-remove-stop -->")){
				lineToDisplay = lines[i].replace("<!-- refonte-remove-stop -->", "")
				isToRemove = false
			}

			if (!lineToDisplay.equals("") && !isToRemove){
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
					File oldFile = new File("${name}-old.${suffix}")
					if ((file.name.contains("css") || file.name.contains("inc")|| file.name.contains("jsp") || file.name.contains("js")) && !file.name.contains("old") && oldFile.exists()){
						print "file to format : ${file} \n"
						if (!formatFile(file, new File("${basePath}\\${file.name}"))){
							file.delete()
						}
					}
				}else{
					formatDir(file, "${basePath}\\${file.name}")
				}
			}
	}
	
	static void formatDirOrig(File fileSrc, String basePath){
		new File(basePath).mkdir()
		fileSrc.eachFile{ File file ->
			if (file.file){
				String name = file.canonicalPath.substring(0, file.canonicalPath.lastIndexOf('.'))
				String suffix = file.name.substring(file.name.lastIndexOf('.')+1)
				File oldFile = new File("${name}-old.${suffix}")
				if ((file.name.contains("css") || file.name.contains("jsp") || file.name.contains("js")) && !file.name.contains("old")){
					print "file to format : ${file} \n"
					formatFile(file, new File("${name}.${suffix}"))
				}
			}else{
				formatDir(file, "${basePath}\\${file.name}")
			}
		}
	}
	
	static main(args) {
		print "start format jsp \n"
		String baseDir = "C:\\Users\\elannemajou\\Desktop\\AppliFormatJsp"
		String category = "TRANSPORT_EXPRESS"
		def dir = new File("${baseDir}\\${category}\\sources")
		formatDir(dir,"${baseDir}\\${category}\\target")
		//formatDirOrig(dir,"${baseDir}\\${category}\\orig")
		print "end format jsp \n"
	}
	
}
