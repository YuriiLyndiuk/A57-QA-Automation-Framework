import org.testng.Assert;
import org.testng.annotations.Test;
import pages.BasePage;
import pages.PlaylistsPage;

import java.util.UUID;

public class PlaylistTest extends BaseTest{
    PlaylistsPage playlistsPage = new PlaylistsPage(driver);
    public String generateRandomName() {
        return UUID.randomUUID().toString().replace("-", "");
    }

    @Test
    public void renamePlaylist(){
        String randomName = generateRandomName();
        String expectedUpdatedPlaylistMsg = "Updated playlist \""+randomName+".\"";
        playlistsPage.renamePlaylist(randomName);
        Assert.assertEquals(playlistsPage.getUpdatedPlaylistNotification(), expectedUpdatedPlaylistMsg);
    }

}
