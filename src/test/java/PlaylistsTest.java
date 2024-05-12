import org.testng.Assert;
import org.testng.annotations.Test;
import pages.LoginPage;

public class PlaylistsTest extends BaseTest{
    @Test
    public void renamePlaylist(){
        String PlaylistName = "homework29";
        String expectedUpdatedPlaylistMsg = "Updated playlist \""+PlaylistName+".\"";

        LoginPage loginPage = new LoginPage(driver);
        pages.PlaylistsPage playlistsPage = new pages.PlaylistsPage(driver);

        loginPage.login("yurii.lyndiuk@testpro.io", "jjbuQe8D");
        playlistsPage.doubleClickOnPlaylist();
        playlistsPage.renamePlaylist(PlaylistName);
        Assert.assertEquals(playlistsPage.getUpdatedPlaylistNotification(), expectedUpdatedPlaylistMsg);
    }
}
