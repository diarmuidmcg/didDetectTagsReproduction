import platform.CoreNFC.NFCNDEFReaderSession
import platform.CoreNFC.NFCNDEFReaderSessionDelegateProtocol
import platform.Foundation.NSError
import platform.darwin.NSObject

class DidDetectTagsExample() : NSObject(), NFCNDEFReaderSessionDelegateProtocol {

    override fun readerSessionDidBecomeActive(session: NFCNDEFReaderSession) {}

    /*
    I add the Suppression due to a problem with the type inference from the Objective C translation.
    Although didDetectNDEFs & didDetectTags return lists of two separate objects, the translation
    returns a wildcard, leading Kotlin to believe that they are duplicate functions (as parameter names are ignored)
     */
//    @Suppress("CONFLICTING_OVERLOADS")
    override fun readerSession(session: NFCNDEFReaderSession, didDetectNDEFs: List<*>) {
        // didDetectNDEFs is a Collection of NFCNDEFMessage
    }

//    @Suppress("CONFLICTING_OVERLOADS")
    override fun readerSession(session: NFCNDEFReaderSession, didDetectTags: List<*>) {
        // didDetectTags is a Collection of NFCNDEFTagProtocol
    }

    override fun readerSession(session: NFCNDEFReaderSession, didInvalidateWithError: NSError) {
        // handle errors
    }
}