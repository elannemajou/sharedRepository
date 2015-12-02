package fr.chronopost.jspfilereader

class JspStaticFilesFormatter {

	static boolean formatFile(File fileSrc, File targetFile){
		List lines = fileSrc.readLines()
		boolean isFormatted = false
		for (int i = 0; i < lines.size(); i++){
			String lineToDisplay = lines[i]
			
//			if (lineToDisplay.contains(".css\"") && lineToDisplay.contains("<link")){
//				lineToDisplay = lines[i].replace(".css\"", ".css?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".js\"></script>")){
//				lineToDisplay = lines[i].replace(".js\"></script>", ".js?version=<ex:StaticVersion/>\"></script>")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".js\"") && lineToDisplay.contains("</script>")){
//				lineToDisplay = lines[i].replace(".js\"", ".js?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}
			
//			if (lineToDisplay.contains(".png\"") && lineToDisplay.contains("<img")){
//				lineToDisplay = lines[i].replace(".png\"", ".png?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".jpg\"") && lineToDisplay.contains("<img")){
//				lineToDisplay = lines[i].replace(".jpg\"", ".jpg?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".jpeg\"") && lineToDisplay.contains("<img")){
//				lineToDisplay = lines[i].replace(".jpeg\"", ".jpeg?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".gif") && lineToDisplay.contains("<img")){
//				lineToDisplay = lines[i].replace(".gif\"", ".gif?version=<ex:StaticVersion/>\"")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".png") && lineToDisplay.contains("image")){
//				lineToDisplay = lines[i].replace(".png", ".png?version=1.0")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".jpg") && lineToDisplay.contains("image")){
//				lineToDisplay = lines[i].replace(".jpg", ".jpg?version=1.0")
//				isFormatted = true;
//			}else if (lineToDisplay.contains(".gif") && lineToDisplay.contains("image")){
//				lineToDisplay = lines[i].replace(".gif", ".gif?version=1.0")
//				isFormatted = true;
//			}

			
			if (lineToDisplay.contains(".png\"") && lineToDisplay.contains("<img")){
				lineToDisplay = lines[i].replace(".png\"", ".png?version=1.0\"")
				isFormatted = true;
			}else if (lineToDisplay.contains(".jpg\"") && lineToDisplay.contains("<img")){
				lineToDisplay = lines[i].replace(".jpg\"", ".jpg?version=1.0\"")
				isFormatted = true;
			}else if (lineToDisplay.contains(".jpeg\"") && lineToDisplay.contains("<img")){
				lineToDisplay = lines[i].replace(".jpeg\"", ".jpeg?version=1.0\"")
				isFormatted = true;
			}else if (lineToDisplay.contains(".gif") && lineToDisplay.contains("<img")){
				lineToDisplay = lines[i].replace(".gif\"", ".gif?version=1.0")
				isFormatted = true;
			}else if (lineToDisplay.contains(".png") && lineToDisplay.contains("image")){
				lineToDisplay = lines[i].replace(".png", ".png?version=1.0")
				isFormatted = true;
			}else if (lineToDisplay.contains(".jpg") && lineToDisplay.contains("image")){
				lineToDisplay = lines[i].replace(".jpg", ".jpg?version=1.0")
				isFormatted = true;
			}else if (lineToDisplay.contains(".gif") && lineToDisplay.contains("image")){
				lineToDisplay = lines[i].replace(".gif", ".gif?version=1.0")
				isFormatted = true;
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
	
	static boolean includeHeader(File fileSrc){
		List lines = fileSrc.readLines()
		for (int i = 0; i < lines.size(); i++){
			if (lines[i].contains("header.jsp")){
				return true
			}
		}
		return false
	}
	
	static boolean addCustomTagLib(File fileSrc, File targetFile){
		List lines = fileSrc.readLines()
		boolean isFormatted = !fileSrc.name.contains("css")
		for (int i = 0; i < lines.size(); i++){
			
			String lineToDisplay = lines[i]
			
			isFormatted = lineToDisplay.contains("\n<%@ taglib uri=\"/META-INF/ex.tld\" prefix=\"ex\"%>")
			
			if ( !isFormatted  && lineToDisplay.contains("<%@ taglib uri=\"http://java.sun.com/jsp/jstl/core\" prefix=\"c\" %>")){
				lineToDisplay = lines[i] + "\n<%@ taglib uri=\"/META-INF/ex.tld\" prefix=\"ex\"%>\n"
				isFormatted = true;
			}
			
			if (!isFormatted && lineToDisplay.contains("<%@ taglib uri=\"/WEB-INF/tld/struts-logic.tld\" prefix=\"logic\"%>")){
				lineToDisplay = lines[i] + "\n<%@ taglib uri=\"/WEB-INF/tld/ex.tld\" prefix=\"ex\"%>\n"
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
					if (file.name.contains("inc") || file.name.contains("jsp")|| file.name.contains("css")){
						print "file to format : ${file} \n"
						File newFile = new File("${basePath}\\${file.name}.tmp")
						if (!formatFile(file, newFile)){
							file.delete()
						}else /*if (!includeHeader(newFile))*/{
							addCustomTagLib(newFile, new File("${basePath}\\${file.name}"))
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
		String baseDir = "C:\\Users\\elannemajou\\Desktop\\AppliFormatStaticJsp"
		String category = "TRANSPORT_EXPRESS"
		def dir = new File("${baseDir}\\${category}\\sources")
		formatDir(dir,"${baseDir}\\${category}\\target")
		print "end format jsp \n"
	}
	
}
