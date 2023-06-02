import android.content.Context
import android.net.ConnectivityManager
import android.net.Network
import com.terrellewis.pixabay.images.core.util.NetworkConnection
import io.mockk.every
import io.mockk.mockk
import io.mockk.slot
import io.mockk.verify
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class NetworkConnectionTest {

    private lateinit var networkConnection: NetworkConnection
    private val context: Context = mockk(relaxed = true)
    private val connectivityManager: ConnectivityManager = mockk(relaxed = true)
    private val network: Network = mockk(relaxed = true)

    @Before
    fun setup() {
        every { context.getSystemService(Context.CONNECTIVITY_SERVICE) } returns connectivityManager
        networkConnection = NetworkConnection(context)
    }

    @Test
    fun testRegisterConnection() {
        val callbackSlot = slot<ConnectivityManager.NetworkCallback>()
        every { connectivityManager.registerDefaultNetworkCallback(capture(callbackSlot)) } answers { nothing }

        networkConnection.registerConnection()

        verify { connectivityManager.registerDefaultNetworkCallback(any()) }
    }

    @Test
    fun testUnregisterConnection() {
        val callbackSlot = slot<ConnectivityManager.NetworkCallback>()
        every { connectivityManager.unregisterNetworkCallback(capture(callbackSlot)) } answers { nothing }

        networkConnection.unregisterConnection()

        verify { connectivityManager.unregisterNetworkCallback(callbackSlot.captured) }
    }

    @Test
    fun testIsConnected() {
        val callbackSlot = slot<ConnectivityManager.NetworkCallback>()
        every { connectivityManager.registerDefaultNetworkCallback(capture(callbackSlot)) } answers { nothing }

        networkConnection.registerConnection()
        callbackSlot.captured.onAvailable(network)

        assertTrue(NetworkConnection.isConnected())

        callbackSlot.captured.onLosing(network, 1000)
        assertFalse(NetworkConnection.isConnected())

        callbackSlot.captured.onLost(network)
        assertFalse(NetworkConnection.isConnected())

        callbackSlot.captured.onUnavailable()
        assertFalse(NetworkConnection.isConnected())
    }
}