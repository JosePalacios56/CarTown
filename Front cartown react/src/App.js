import React, { Component } from "react";
import { Switch, Route, Link} from "react-router-dom";
import "bootstrap/dist/css/bootstrap.min.css";
import "./App.css";
import AppBar from '@material-ui/core/AppBar';
import HomeIcon from '@material-ui/icons/Home';
import CssBaseline from '@material-ui/core/CssBaseline';
import Toolbar from '@material-ui/core/Toolbar';
import { makeStyles } from '@material-ui/core/styles';


import CocheService from './services/coche.service';
import Catalogo from './components/catalogo';
import Comparador from './components/compararCoches'
import ComprarVehiculo from "./components/comprarVehiculo"



class App extends Component {

constructor(props){
  super(props);
  this.state={
    coches:[]
  }
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
    return (
      <div>
            <React.Fragment>

        <CssBaseline/>
        <AppBar position="relative" >
        <Toolbar>
        <HomeIcon className={classes.icon} />
        <Link to={"/"} className="navbar-brand">
            Inicio
          </Link>
          <Link to={"/comparador"} className="navbar-brand">
            Menu 2
          </Link>
        </Toolbar>
      </AppBar>

      </React.Fragment>

  

        <div className="container mt-3">
           
          <Switch>
            
          { <Route exact path="/" component={Catalogo} />}
          { <Route exact path="/comparador" component={Comparador} />}
          { <Route exact path="/comprar" component={ComprarVehiculo} />}
         
          </Switch>
        

        </div>
      </div>
    );
  }
}

export default App;
