import React, { Component } from "react";
import { Link} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "../App.css";
import { Modal, ModalBody, ModalHeader, ModalFooter } from "reactstrap";


import Card from '@material-ui/core/Card';
import CardActions from '@material-ui/core/CardActions';
import CardContent from '@material-ui/core/CardContent';
import CardMedia from '@material-ui/core/CardMedia';
import CssBaseline from '@material-ui/core/CssBaseline';
import Grid from '@material-ui/core/Grid';
import Typography from '@material-ui/core/Typography';
import { makeStyles } from '@material-ui/core/styles';
import Container from '@material-ui/core/Container';
import CocheService from "../services/coche.service";

export default class Catalogo extends Component {
  constructor(props){
    super(props);
    this.state={
      coches:[],
      modalDetalle: false,
      coche:[{marca:"prueba"}]
    }
    this.abrirModal=this.abrirModal.bind(this);
    this.seleccionarCoche=this.seleccionarCoche.bind(this);
    this.cerrarModal=this.cerrarModal.bind(this);
  }
  
  componentDidMount() {
        CocheService.getAll()
        .then(response => {
          this.setState({
            coches: response.data
          });
          console.log(response.data);
        })
        .catch(e => {
          console.log(e);
        });
       
      }

    seleccionarCoche(cocheSeleccionado){
      
      this.setState(
        {coche: cocheSeleccionado})
        console.log(this.state.coche);
        if(this.state.coche===null){}else{
        this.abrirModal();
        }
      }
      abrirModal(){
        this.setState({modalDetalle:true})

      }

    cerrarModal(){
  
      this.setState(
        {modalDetalle: false})

    }
      
        
      
    render() {
  
      const useStyles=makeStyles((theme) => ({
    icon: {
      marginRight: theme.spacing(2),
    },
    heroContent: {
      backgroundColor: theme.palette.background.paper,
      padding: theme.spacing(8, 0, 6),
    },
    heroButtons: {
      marginTop: theme.spacing(4),
    },
    cardGrid: {
      paddingTop: theme.spacing(8),
      paddingBottom: theme.spacing(8),
    },
    card: {
      height: '100%',
      display: 'flex',
      flexDirection: 'column',
    },
    cardMedia: {
      paddingTop: '56.25%', // 16:9
    },
    cardContent: {
      flexGrow: 1,
    },
    footer: {
      backgroundColor: theme.palette.background.paper,
      padding: theme.spacing(6),
    },
  }));
  
  const classes=useStyles;
  const cards=this.state.coches;
      return (
        <div className="fondo">
        <React.Fragment>
  
          <CssBaseline/>

  
        <main>
          {/* Hero unit */}
          <div className={classes.heroContent}>
            <Container maxWidth="sm">
              <Typography component="h1" variant="h2" align="center" color="textPrimary" gutterBottom>
                CarTown
              </Typography>
              <Typography variant="h5" align="center" color="textSecondary" paragraph>
                Encuentra el vehiculo que siempre has querido. 
              </Typography>
              <div className={classes.heroButtons}>
              </div>
            </Container>
          </div>
          <Container className={classes.cardGrid} maxWidth="md">
            <Grid container spacing={4}>
              {cards.map((card) => (
                <Grid item key={card.id} xs={12} sm={6} md={4}>
                  <Card className={classes.card}>
                    <CardMedia
                      style={{height: 0, paddingTop: '56.25%'}}
                      image={card.imagenes[0]}
                      title="Coche "
                    />
                    <CardContent className={classes.cardContent}>    
                      {card.marca}
                      <Typography>
                      {card.modelo}
                      </Typography>
                    </CardContent>
                    <CardActions>
                    <button className="btn btn-primary" onClick={()=>this.seleccionarCoche(card)}>Ver detalles</button>
                    <Link to={"/comprar"} className="navbar-brand">
                       Solicitar Prueba
                    </Link>
      
                    </CardActions>
                  </Card>
                </Grid>
              ))}
            </Grid>
          </Container>
          <Modal isOpen={this.state.modalDetalle}>
      <ModalHeader>Ver detalles</ModalHeader>
      <ModalBody>
        <div className="form-group">
          
          
          <br></br>
          <label>Marca</label>
          <h3 align="center"> {this.state.coche.marca}</h3>

          <label>Modelo</label>
          <h3 align="center">{this.state.coche.modelo}</h3>

          <label>Potencia</label>
          <h3 align="center">{this.state.coche.potencia}</h3>
          
          <label>Marchas</label>
          <h3 align="center">{this.state.coche.marchas}</h3>
          
          <label>Plazas</label>
          <h3 align="center">{this.state.coche.plazas}</h3>
          
          
          <label>Combustible</label>
          <h3 align="center">{this.state.coche.combustible}</h3>

          <br></br>
          <label>Color</label>
          <h3 align="center">{this.state.coche.color}</h3>
          

        </div>
      </ModalBody>
      <ModalFooter>
        <button className="btn btn-primary" onClick={()=>this.cerrarModal()} >Cerrar</button>
      </ModalFooter>
    </Modal>
        </main>

      
        </React.Fragment>
        </div>
      );
    }
  }

