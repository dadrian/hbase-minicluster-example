package local.example;

import org.apache.hadoop.hbase.HBaseTestingUtility;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.util.Bytes;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class HbaseTest {

  private HBaseTestingUtility utility;

  @Before
  public void setUp() throws Exception {
    System.setProperty("org.apache.hadoop.hbase.shaded.io.netty.packagePrefix",
            "org.apache.hadoop.hbase.shaded.");
    utility = new HBaseTestingUtility();
    utility.startMiniCluster();
    HTable table = utility.createTable(TableName.valueOf("test_table"),
        new byte[][]{Bytes.toBytes("a"), Bytes.toBytes("b"), Bytes.toBytes("c")});
  }

  @After
  public void tearDown() throws Exception {
    utility.shutdownMiniHBaseCluster();
  }

  @Test
  public void testTrue() throws Exception {
    assertEquals(true, true);
  }
}
