package com.uniquindio.FincApp;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.uniquindio.FincApp.dao.IControlDao;
import com.uniquindio.FincApp.dao.ICultivationDao;
import com.uniquindio.FincApp.dao.IEmployeeDao;
import com.uniquindio.FincApp.dao.IEmployeeHarvestDao;
import com.uniquindio.FincApp.dao.IEstateDao;
import com.uniquindio.FincApp.dao.IHaverstDao;
import com.uniquindio.FincApp.dao.IPositionDao;
import com.uniquindio.FincApp.dto.ControlDTO;
import com.uniquindio.FincApp.dto.CultivationDTO;
import com.uniquindio.FincApp.dto.EmployeeDTO;
import com.uniquindio.FincApp.dto.EmployeeHarvestDTO;
import com.uniquindio.FincApp.dto.HarvestDTO;
import com.uniquindio.FincApp.dto.PositionDTO;
import com.uniquindio.FincApp.model.Control;
import com.uniquindio.FincApp.model.Cultivation;
import com.uniquindio.FincApp.model.Employee;
import com.uniquindio.FincApp.model.EmployeeHarvest;
import com.uniquindio.FincApp.model.Estate;
import com.uniquindio.FincApp.model.Harvest;
import com.uniquindio.FincApp.model.Position;
import com.uniquindio.FincApp.service.ControlServiceImpl;
import com.uniquindio.FincApp.service.CultivationServiceImpl;
import com.uniquindio.FincApp.service.EmployeeHarvestServiceImpl;
import com.uniquindio.FincApp.service.EmployeeServiceImpl;
import com.uniquindio.FincApp.service.HaverstServiceImpl;
import com.uniquindio.FincApp.service.PositionServicioImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
class FincAppApplicationTests {

	@MockBean
	ICultivationDao cultivationDao;
	@Autowired
	private CultivationServiceImpl cultivationService;
	@MockBean
	IControlDao controlDao;
	@Autowired
	private ControlServiceImpl controlService;
	@MockBean
	IEmployeeHarvestDao employeeHarvestDao;
	@Autowired
	private EmployeeHarvestServiceImpl employeeHarvestService;
	@MockBean
	IHaverstDao haverstDao;
	@Autowired
	private HaverstServiceImpl haverstService;
	@Autowired
	private PositionServicioImpl positionServicio;
	@MockBean
	IPositionDao positionDao;	
	@MockBean
	IEmployeeDao employeeDao;
	@Autowired
	private EmployeeServiceImpl employeeService;
	@MockBean
	IEstateDao fincaDao;
	@Test
	public void createCultivation() {
		Cultivation cultivo = new Cultivation();
		CultivationDTO cultivoDTO = new CultivationDTO();
		cultivo.setIdcultivo(1L);
		when(cultivationDao.save(any())).thenReturn(cultivo);
		assertThat(cultivationService.saveCultivation(cultivoDTO)).isNotNull();
	}
	@Test
	public void findByIdCultivation() {
		Optional<Cultivation> cultivo = Optional.ofNullable(new Cultivation());
		when(cultivationDao.findById(any())).thenReturn(cultivo);
		assertThat(cultivationService.findById(any())).isNotNull();
	}
	@Test
	public void createControl() {
		Control control = new Control();
		ControlDTO controlDTO = new ControlDTO();
		control.setIdcontrol(1L);
		Optional<Cultivation> cultivo = Optional.ofNullable(new Cultivation());
		when(cultivationDao.findById(any())).thenReturn(cultivo);
		when(controlDao.save(any())).thenReturn(control);
		assertThat(controlService.saveControl(controlDTO)).isNotNull();
	}
	@Test
	public void findByIdControl() {
		Cultivation cultivo = new Cultivation();
		Optional<Control> control = Optional.ofNullable(new Control());
		control.get().setCultivo(cultivo);
		control.get().getCultivo().setIdcultivo(1L);
		when(controlDao.findById(any())).thenReturn(control);
		assertThat(controlService.findById(any())).isNotNull();
	}
	@Test
	public void createEmployeeHarvest() {
		EmployeeHarvest employee = new EmployeeHarvest();
		EmployeeHarvestDTO employeeDTO = new EmployeeHarvestDTO();
		employee.setCedula(1L);
		Optional<Cultivation> cultivo = Optional.ofNullable(new Cultivation());
		when(cultivationDao.findById(any())).thenReturn(cultivo);
		when(employeeHarvestDao.save(any())).thenReturn(employee);
		assertThat(employeeHarvestService.saveEmployeeHarvest(employeeDTO)).isNotNull();
	}
	@Test
	public void findByIdEmployeeHarvest() {
		Cultivation cultivo = new Cultivation();
		Optional<EmployeeHarvest> employee = Optional.ofNullable(new EmployeeHarvest());
		employee.get().setCultivo(cultivo);
		employee.get().getCultivo().setIdcultivo(1L);
		when(employeeHarvestDao.findById(any())).thenReturn(employee);
		assertThat(employeeHarvestService.findById(any())).isNotNull();
	}
	@Test
	public void createHarvest() {
		Harvest harvest = new Harvest();
		HarvestDTO harvestDTO = new HarvestDTO();
		harvest.setIdcosecha(1L);
		Optional<Cultivation> cultivo = Optional.ofNullable(new Cultivation());
		when(cultivationDao.findById(any())).thenReturn(cultivo);
		when(haverstDao.save(any())).thenReturn(harvest);
		assertThat(haverstService.saveHarvest(harvestDTO)).isNotNull();
	}
	@Test
	public void findByIdHarvest() {
		Cultivation cultivo = new Cultivation();
		Optional<Harvest> harvest = Optional.ofNullable(new Harvest());
		harvest.get().setCultivo(cultivo);
		harvest.get().getCultivo().setIdcultivo(1L);
		when(haverstDao.findById(any())).thenReturn(harvest);
		assertThat(haverstService.findById(any())).isNotNull();
	}
	@Test
	public void createPosition() {
		Position position = new Position();
		PositionDTO positionDTO = new PositionDTO();
		position.setIdCargo(1L);
		Optional<Employee> employee = Optional.ofNullable(new Employee());
		when(employeeDao.findById(any())).thenReturn(employee);
		when(positionDao.save(any())).thenReturn(position);
		assertThat(positionServicio.savePosition(positionDTO)).isNotNull();
	}
	@Test
	public void findByIdPosition() {
		Employee employee = new Employee();
		Optional<Position> position = Optional.ofNullable(new Position());
		position.get().setTrabajadorCedula(employee);
		position.get().getTrabajadorCedula().setCedula(1L);
		when(positionDao.findById(any())).thenReturn(position);
		assertThat(positionServicio.findById(any())).isNotNull();
	}
	@Test
	public void createEmployee() {
		Employee employee = new Employee();
		EmployeeDTO employeeDTO = new EmployeeDTO();
		employee.setCedula(1L);
		Optional<Estate> finca = Optional.ofNullable(new Estate());
		when(fincaDao.findById(any())).thenReturn(finca);
		Optional<Cultivation> cultivo = Optional.ofNullable(new Cultivation());
		when(cultivationDao.findById(any())).thenReturn(cultivo);
		when(employeeDao.save(any())).thenReturn(employee);
		assertThat(employeeService.saveEmployee(employeeDTO)).isNotNull();
	}
	@Test
	public void findByIdEmployee() {
		Estate finca = new Estate();
		Cultivation cultivo = new Cultivation();
		Optional<Employee> employee = Optional.ofNullable(new Employee());
		employee.get().setFinca(finca);
		employee.get().getFinca().setIdfinca(1L);
		employee.get().setCultivo(cultivo);
		employee.get().getCultivo().setIdcultivo(1L);
		when(employeeDao.findById(any())).thenReturn(employee);
		assertThat(employeeService.findById(any())).isNotNull();
	}
}
