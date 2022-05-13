package hu.bme.mit.spaceship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.*;

public class GT4500Test {

  private GT4500 ship;
  private TorpedoStore firstDA;
  private TorpedoStore secondDA;

  @BeforeEach
  public void init(){
    this.firstDA =mock(TorpedoStore. class);
    this.secondDA=mock(TorpedoStore.class);
    this.ship = new GT4500(firstDA, secondDA);

  }

  @Test
  public void fireTorpedo_Single_Success(){
    // Arrange
    when(firstDA.fire(1)).thenReturn(true);
    when(secondDA.fire(1)).thenReturn(true);

    // Act
    ship.fireTorpedo(FiringMode.SINGLE);

    // Assert
    verify(firstDA, times(1)).fire(1);
  }

  @Test
  public void fireTorpedo_All_Success(){
    // Arrange

    // Act
    ship.fireTorpedo(FiringMode.ALL);

    // Assert
    verify(firstDA, times(1)).fire(1);
    verify(secondDA, times(1)).fire(1);

  }

}
