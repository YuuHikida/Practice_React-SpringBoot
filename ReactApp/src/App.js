import logo from './logo.svg';
import './App.css';
import { ApiFetch } from "./components/ApiFetch"; //追加
import  EntityList  from "./components/EntityList";
import NotFound from "./components/NotFound";
import {
  useParams,
  useHistory,
  useLocation,
  BrowserRouter,
  Routes,
  Route
} from 'react-router-dom';
import AppReactLogo from "./AppLogo";


function App() {
  return (
  <BrowserRouter>
      <Routes>
        <Route path={'/'} element={<AppReactLogo />}/>
        <Route path={'/api'} element={<ApiFetch />}/>
        <Route path= "/api/:id" element={<EntityList />}/>

        <Route path='*' element={<NotFound />}/>
      </Routes>
  </BrowserRouter>
  );
}

export default App;
