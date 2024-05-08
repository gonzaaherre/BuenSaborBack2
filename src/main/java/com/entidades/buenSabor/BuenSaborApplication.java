package com.entidades.buenSabor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.entidades.buenSabor.repositories.*;

@SpringBootApplication
public class BuenSaborApplication {

	private static final Logger logger = LoggerFactory.getLogger(BuenSaborApplication.class);

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private PaisRepository paisRepository;

	@Autowired
	private ProvinciaRepository provinciaRepository;

	@Autowired
	private LocalidadRepository localidadRepository;

	@Autowired
	private DomicilioRepository domicilioRepository;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private SucursalRepository	sucursalRepository;


	@Autowired
	private UnidadMedidaRepository unidadMedidaRepository;

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ArticuloInsumoRepository articuloInsumoRepository;

	@Autowired
	private ArticuloManufacturadoRepository articuloManufacturadoRepository;

	@Autowired
	private PromocionRepository promocionRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(BuenSaborApplication.class, args);
		logger.info("Estoy activo en el main");
	}
/*
	@Bean
	@Transactional
	CommandLineRunner init () {
		return args -> {
			logger.info("----------------ESTOY----FUNCIONANDO---------------------");
			// Etapa del dashboard
			// Crear 1 pais
			// Crear 2 provincias para ese pais
			// crear 2 localidades para cada provincia
			Pais pais1 = Pais.builder().nombre("Argentina").build();
			Provincia provincia1 = Provincia.builder().nombre("Mendoza").pais(pais1).build();
			Provincia provincia2 = Provincia.builder().nombre("Cordoba").pais(pais1).build();
			Localidad localidad1 = Localidad.builder().nombre("Lujan de Cuyo").provincia(provincia1).build();
			Localidad localidad2 = Localidad.builder().nombre("Godoy Cruz").provincia(provincia1).build();
			Localidad localidad3 = Localidad.builder().nombre("Achiras").provincia(provincia2).build();
			Localidad localidad4 = Localidad.builder().nombre("Agua de Oro").provincia(provincia2).build();

			paisRepository.save(pais1);
			provinciaRepository.save(provincia1);
			provinciaRepository.save(provincia2);
			localidadRepository.save(localidad1);
			localidadRepository.save(localidad2);
			localidadRepository.save(localidad3);
			localidadRepository.save(localidad4);

			// Crear 1 empresa
			// Crear 2 sucursales para esa empresa
			// crear los Domicilios para esas sucursales
			Empresa empresaBrown = Empresa.builder().nombre("Lo de Brown").cuil(30503167).razonSocial("Venta de Alimentos").build();
			Sucursal sucursalChacras = Sucursal.builder().nombre("En chacras").horarioApertura(LocalTime.of(17,0)).horarioCierre(LocalTime.of(23,0)).build();
			Sucursal sucursalGodoyCruz = Sucursal.builder().nombre("En godoy cruz").horarioApertura(LocalTime.of(16,0)).horarioCierre(LocalTime.of(23,30)).build();
			Domicilio domicilioViamonte = Domicilio.builder().cp(5509).calle("Viamonte").numero(500).piso(2).nroDpto(23).localidad(localidad1).build();
			Domicilio domicilioSanMartin = Domicilio.builder().cp(5511).calle("San Martin").numero(789).localidad(localidad2).build();

			sucursalChacras.setEmpresa(empresaBrown);
			sucursalChacras.setDomicilio(domicilioViamonte);
			sucursalGodoyCruz.setEmpresa(empresaBrown);
			sucursalGodoyCruz.setDomicilio(domicilioSanMartin);
			empresaBrown.getSucursales().add(sucursalChacras);
			empresaBrown.getSucursales().add(sucursalGodoyCruz);
			empresaRepository.save(empresaBrown);
			sucursalRepository.save(sucursalChacras);
			sucursalRepository.save(sucursalGodoyCruz);

			// Crear Unidades de medida
			UnidadMedida unidadMedidaLitros = UnidadMedida.builder().denominacion("Litros").build();
			UnidadMedida unidadMedidaGramos = UnidadMedida.builder().denominacion("Gramos").build();
			UnidadMedida unidadMedidaCantidad = UnidadMedida.builder().denominacion("Cantidad").build();
			UnidadMedida unidadMedidaPorciones = UnidadMedida.builder().denominacion("Porciones").build();
			unidadMedidaRepository.save(unidadMedidaLitros);
			unidadMedidaRepository.save(unidadMedidaGramos);
			unidadMedidaRepository.save(unidadMedidaCantidad);
			unidadMedidaRepository.save(unidadMedidaPorciones);

			// Crear Categorías de productos y subCategorías de los mismos
			Categoria categoriaBebidas = Categoria.builder().denominacion("Bebidas").build();
			Categoria categoriaGaseosas = Categoria.builder().denominacion("Gaseosas").build();
			Categoria categoriaTragos = Categoria.builder().denominacion("Tragos").build();
			Categoria categoriaPizzas = Categoria.builder().denominacion("Pizzas").build();

			categoriaPizzas.getSucursales().add(sucursalChacras);
			categoriaPizzas.getSucursales().add(sucursalGodoyCruz);
			categoriaGaseosas.getSucursales().add(sucursalChacras);
			categoriaGaseosas.getSucursales().add(sucursalGodoyCruz);
			categoriaTragos.getSucursales().add(sucursalChacras);
			categoriaTragos.getSucursales().add(sucursalGodoyCruz);
			categoriaBebidas.getSucursales().add(sucursalChacras);
			categoriaBebidas.getSucursales().add(sucursalGodoyCruz);

			categoriaRepository.save(categoriaBebidas);
			categoriaRepository.save(categoriaGaseosas);
			categoriaRepository.save(categoriaTragos);
			categoriaRepository.save(categoriaPizzas);
			categoriaBebidas.getSubCategorias().add(categoriaGaseosas);
			categoriaBebidas.getSubCategorias().add(categoriaTragos);

			categoriaRepository.save(categoriaBebidas);

			// Crear Insumos , coca cola , harina , etc
			ArticuloInsumo cocaCola = ArticuloInsumo.builder().denominacion("Coca cola").unidadMedida(unidadMedidaLitros).esParaElaborar(false).stockActual(5).stockMaximo(50).precioCompra(50.0).precioVenta(70.0).build();
			ArticuloInsumo harina = ArticuloInsumo.builder().denominacion("Harina").unidadMedida(unidadMedidaGramos).esParaElaborar(true).stockActual(4).stockMaximo(40).precioCompra(40.0).precioVenta(60.5).build();
			ArticuloInsumo queso = ArticuloInsumo.builder().denominacion("Queso").unidadMedida(unidadMedidaGramos).esParaElaborar(true).stockActual(20).stockMaximo(50).precioCompra(23.6).precioVenta(66.6).build();
			ArticuloInsumo tomate = ArticuloInsumo.builder().denominacion("Tomate").unidadMedida(unidadMedidaCantidad).esParaElaborar(true).stockActual(20).stockMaximo(50).precioCompra(23.6).precioVenta(66.6).build();

			// crear fotos para cada insumo
			Imagen imagenCoca = Imagen.builder().denominacion("https://m.media-amazon.com/images/I/51v8nyxSOYL._SL1500_.jpg").build();
			Imagen imagenHarina = Imagen.builder().denominacion("https://mandolina.co/wp-content/uploads/2023/03/648366622-1024x683.jpg").build();
			Imagen imagenQueso = Imagen.builder().denominacion("https://superdepaso.com.ar/wp-content/uploads/2021/06/SANTAROSA-PATEGRAS-04.jpg").build();
			Imagen imagenTomate = Imagen.builder().denominacion("https://thefoodtech.com/wp-content/uploads/2020/06/Componentes-de-calidad-en-el-tomate-828x548.jpg").build();

			cocaCola.getImagenes().add(imagenCoca);
			harina.getImagenes().add(imagenHarina);
			queso.getImagenes().add(imagenQueso);
			tomate.getImagenes().add(imagenTomate);
			articuloInsumoRepository.save(cocaCola);
			articuloInsumoRepository.save(harina);
			articuloInsumoRepository.save(queso);
			articuloInsumoRepository.save(tomate);

			// Crear Articulos Manufacturados
			ArticuloManufacturado pizzaMuzarella = ArticuloManufacturado.builder().denominacion("Pizza Muzarella").descripcion("Una pizza clasica").unidadMedida(unidadMedidaPorciones).precioVenta(130.0).tiempoEstimadoMinutos(15).preparacion("Pasos de preparacion de una muzza de toda la vida").build();
			ArticuloManufacturado pizzaNapolitana = ArticuloManufacturado.builder().denominacion("Pizza Muzarella").descripcion("Una pizza clasica").unidadMedida(unidadMedidaPorciones).precioVenta(150.0).tiempoEstimadoMinutos(15).preparacion("Pasos de preparacion de una pizza napolitana italiana").build();

			// Crear fotos para los artículos manufacturados
			Imagen imagenPizzaMuzarella = Imagen.builder().denominacion("https://storage.googleapis.com/fitia-api-bucket/media/images/recipe_images/1002846.jpg").build();
			Imagen imagenPizzaNapolitana = Imagen.builder().denominacion("https://assets.elgourmet.com/wp-content/uploads/2023/03/8metlvp345_portada-pizza-1024x686.jpg.webp").build();

			pizzaMuzarella.getImagenes().add(imagenPizzaMuzarella);
			pizzaNapolitana.getImagenes().add(imagenPizzaNapolitana);
			articuloManufacturadoRepository.save(pizzaMuzarella);
			articuloManufacturadoRepository.save(pizzaNapolitana);

			// Establecer las relaciones entre estos objetos.
			ArticuloManufacturadoDetalle detalle1 = ArticuloManufacturadoDetalle.builder().articuloInsumo(harina).cantidad(300).build();
			ArticuloManufacturadoDetalle detalle2 = ArticuloManufacturadoDetalle.builder().articuloInsumo(queso).cantidad(600).build();
			ArticuloManufacturadoDetalle detalle3 = ArticuloManufacturadoDetalle.builder().articuloInsumo(harina).cantidad(350).build();
			ArticuloManufacturadoDetalle detalle4 = ArticuloManufacturadoDetalle.builder().articuloInsumo(queso).cantidad(650).build();
			ArticuloManufacturadoDetalle detalle5 = ArticuloManufacturadoDetalle.builder().articuloInsumo(tomate).cantidad(2).build();

			pizzaMuzarella.getArticuloManufacturadoDetalles().add(detalle1);
			pizzaMuzarella.getArticuloManufacturadoDetalles().add(detalle2);
			pizzaNapolitana.getArticuloManufacturadoDetalles().add(detalle3);
			pizzaNapolitana.getArticuloManufacturadoDetalles().add(detalle4);
			pizzaNapolitana.getArticuloManufacturadoDetalles().add(detalle5);
			articuloManufacturadoRepository.save(pizzaMuzarella);
			articuloManufacturadoRepository.save(pizzaNapolitana);

			// Establecer relaciones de las categorias
			categoriaGaseosas.getArticulos().add(cocaCola);
			categoriaPizzas.getArticulos().add(pizzaMuzarella);
			categoriaPizzas.getArticulos().add(pizzaNapolitana);
			categoriaRepository.save(categoriaGaseosas);
			categoriaRepository.save(categoriaPizzas);

			// Crear promocion para sucursal - Dia de los enamorados
			// Tener en cuenta que esa promocion es exclusivamente para una sucursal determinada d euna empresa determinada
			Promocion promocionDiaEnamorados = Promocion.builder().denominacion("Dia de los Enamorados")
					.fechaDesde(LocalDate.of(2024,2,13))
					.fechaHasta(LocalDate.of(2024,2,15))
					.horaDesde(LocalTime.of(0,0))
					.horaHasta(LocalTime.of(23,59))
					.descripcionDescuento("El descuento que se hace por san valentin, un dia antes y un dia despues")
					.precioPromocional(100.0)
					.tipoPromocion(TipoPromocion.promocion)
					.build();
			promocionDiaEnamorados.getArticulos().add(cocaCola);
			promocionDiaEnamorados.getArticulos().add(pizzaNapolitana);
			sucursalChacras.getPromociones().add(promocionDiaEnamorados);

			promocionRepository.save(promocionDiaEnamorados);

			cocaCola.getPromociones().add(promocionDiaEnamorados);
			pizzaMuzarella.getPromociones().add(promocionDiaEnamorados);

			//Agregar categorias y promociones a sucursales
			sucursalChacras.getCategorias().add(categoriaBebidas);
			sucursalChacras.getCategorias().add(categoriaPizzas);
			sucursalChacras.getPromociones().add(promocionDiaEnamorados);

			sucursalGodoyCruz.getCategorias().add(categoriaBebidas);
			sucursalGodoyCruz.getCategorias().add(categoriaPizzas);

			sucursalRepository.save(sucursalChacras);
			sucursalRepository.save(sucursalGodoyCruz);

			//Crea un cliente y un usuario
			Imagen imagenCliente = Imagen.builder().denominacion("https://hips.hearstapps.com/hmg-prod/images/la-la-land-final-1638446140.jpg").build();

			Usuario usuario = Usuario.builder().username("sebastian").auth0Id("9565a49d-ecc1-4f4e-adea-6cdcb7edc4a3").build();
			usuarioRepository.save(usuario);

			Domicilio domicilioCliente = Domicilio.builder().cp(5509).calle("Paso Los Andes").numero(500).piso(2).nroDpto(23).localidad(localidad1).build();
			Domicilio domicilioCliente2 = Domicilio.builder().cp(5509).calle("Pascual Segura").numero(2413).localidad(localidad1).build();

			Cliente cliente = Cliente.builder()
					.imagen(imagenCliente)
					.email("correoFalso@gmail.com")
					.nombre("Sebastian")
					.apellido("Wilder")
					.telefono("2615920825")
					.usuario(usuario)
					.fechaNacimiento(LocalDate.of(2000,1,5))
					.build();

			cliente.getDomicilios().add(domicilioCliente);
			cliente.getDomicilios().add(domicilioCliente2);
			clienteRepository.save(cliente);

			//Crea un pedido para el cliente
			Pedido pedido = Pedido.builder()
					.fechaPedido(LocalDate.now())
					.horaEstimadaFinalizacion(LocalTime.now())
					.total(300.0)
					.totalCosto(170.6)
					.estado(Estado.Preparacion)
					.formaPago(FormaPago.MercadoPago)
					.tipoEnvio(TipoEnvio.Delivery)
					.sucursal(sucursalChacras)
					.sucursal(sucursalGodoyCruz)
					.cliente(cliente)
					.domicilio(domicilioViamonte).build();

			DetallePedido detallePedido1 = DetallePedido.builder().articulo(pizzaMuzarella).cantidad(1).subTotal(200.0).build();
			DetallePedido detallePedido2 = DetallePedido.builder().articulo(cocaCola).cantidad(2).subTotal(100.0).build();

			pedido.getDetallePedidos().add(detallePedido1);
			pedido.getDetallePedidos().add(detallePedido2);
			pedidoRepository.save(pedido);

			cliente.getPedidos().add(pedido);
			clienteRepository.save(cliente);

		};
	}
*/
}
