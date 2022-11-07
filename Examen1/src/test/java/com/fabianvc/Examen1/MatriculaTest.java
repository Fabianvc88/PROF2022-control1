package com.fabianvc.Examen1;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import java.util.Vector;

public class MatriculaTest {

	@Test
	void vectorAsignaturaNuloCausaExcepcion() {
		Matricula m = new Matricula(null);
		
		assertThrows(Exception.class, () -> {m.getImporte();}, "Exception ejecutadas");
	}
	
	@Test
	void calcularImporteAsignatura() throws Exception {
		Asignatura as1 = mock(Asignatura.class);
		Asignatura as2 = mock(Asignatura.class);
		Vector<Asignatura> vectAsig = new Vector<Asignatura>();
		
		when(as1.getImporte()).thenReturn((double) 150);
		when(as2.getImporte()).thenReturn((double) 200);		
		
		vectAsig.add(as1);
		vectAsig.add(as2);
		
		Matricula m = new Matricula(vectAsig);
		
		assertEquals((double) 350, m.getImporte(), 0.1);
	}

	@Test
	void getImporteRecorreTodasLasAsignaturas() throws Exception {
		Asignatura as1 = mock(Asignatura.class);
		Asignatura as2 = mock(Asignatura.class);
		Vector<Asignatura> vectAsig = new Vector<Asignatura>();
		
		vectAsig.add(as1);
		vectAsig.add(as2);
		
		Matricula m = new Matricula(vectAsig);
		
		m.getImporte();
		for(Asignatura i: m.vectorAsignaturas) {
			verify(i, times(1)).getImporte();
		}
		//otra forma
		/*verify(as1, times(1)).getImporte();
		verify(as2, times(1)).getImporte();*/
	}
}
