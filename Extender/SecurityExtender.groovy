def changes = []

public class MyData {

  def theFile = ""

  def extMarker =
"""
"""
  def srcInsert =
"""
"""
}
MyData newData = new MyData()


//
// End remember member selection
//

newData = new MyData()
newData.theFile = "MovementMovementVideoVideoSave.java"
newData.extMarker = "    private static final String TAG = \"MovementMovementVideoVideoSave\";"
newData.srcInsert = "    private static final String TAG = \"MovementVideoSave\";"
changes.add(newData)

newData = new MyData()
newData.theFile = "SecurityCameraMovementVideoSecurity.java"
newData.extMarker = "  private static final String TAG = \"SecurityCameraMovementVideoSecurity\";"
newData.srcInsert = "  private static final String TAG = \"SecurityMovementVideo\";"
changes.add(newData)

//
// Posting tag changes in 'post' dir (to enforce logger rules that tags can be at most 23 characters long)
//

newData = new MyData()
newData.theFile = "SyncSecurityCameraServerHelper.java"
newData.extMarker = "    public static final String TAG = \"SyncSecurityCameraServer\";"
newData.srcInsert = "    public static final String TAG = \"SyncSCamera_to_Server\";"
changes.add(newData)

//
// Sync file change
// 
def dir = "../security"

def extFiles ( theDir, changes ) {

   def fileList = new File(theDir).list().toList()

   for ( i in fileList ) {

      def inFile = theDir + "/" + i
      def f1= new File(inFile)

      MyData myData = new MyData();

      if ( f1.isDirectory() ) {
         extFiles ( inFile, changes )
      } else {
//println(i)
        for (c in changes) {
          MyData theData = c
          if ( i.equals(theData.theFile) ) {
            def oldFile = new File(inFile).text
            def newMarker = theData.extMarker 
            def newSrc = theData.srcInsert  
            def newFile = oldFile.replace(newMarker, newSrc)
            new File(inFile).write(newFile)
            if (newFile.contains(newSrc) == false) { println(theData.theFile + " missing changes") }
          }

        }

      } 
   }
}

extFiles ( dir, changes )


//add files
//
def strings = new File("./strings.xml").text
new File("../security/app/src/main/res/values/strings.xml").write(strings)

def src = new File("./logo.png").newDataInputStream()
def dst = new File("../security/app/src/main/res/drawable/logo.png").newDataOutputStream()
dst << src

def src1 = new File("./logo.png").newDataInputStream()
def dst1 = new File("../security/app/src/main/res/drawable-hdpi/logo.png").newDataOutputStream()
dst1 << src1

def src2 = new File("./logo.png").newDataInputStream()
def dst2 = new File("../security/app/src/main/res/drawable-ldpi/logo.png").newDataOutputStream()
dst2 << src2

def src3 = new File("./logo.png").newDataInputStream()
def dst3 = new File("../security/app/src/main/res/drawable-mdpi/logo.png").newDataOutputStream()
dst3 << src3

def src4 = new File("./logo.png").newDataInputStream()
def dst4 = new File("../security/app/src/main/res/drawable-xhdpi/logo.png").newDataOutputStream()
dst4 << src4

def src5 = new File("./logo.png").newDataInputStream()
def dst5 = new File("../security/app/src/main/res/drawable-xxhdpi/logo.png").newDataOutputStream()
dst5 << src5