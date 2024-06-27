import logo from './logo.svg';
import './App.css';
import { ApiFetch } from "./components/ApiFetch"; //追加
import  EntityList  from "./components/EntityList";
import {
  useParams,
  useHistory,
  useLocation,
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';
import AppReactLogo from "./App_BackUp";

function App() {
  return (
  <BrowserRouter>
      <Routes>
        <Route path={'/'} element={<AppReactLogo />}/>
      </Routes>
  </BrowserRouter>
  );
}

export default App;
