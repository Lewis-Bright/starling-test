import { Results } from "./Results"
import * as axios from 'axios'
import Enzyme, { mount } from 'enzyme'
import Adapter from 'enzyme-adapter-react-16'
import { act } from "react-dom/test-utils";

jest.mock("axios");
Enzyme.configure({ adapter: new Adapter() })
describe("Results spec", () => {
  afterEach(() => {
    jest.clearAllMocks();
  });

  it("Makes request for savings", async () => {
    let wrapper;

    await act(async () => {
      await axios.post.mockImplementationOnce(() => Promise.resolve({ data: { totalSavingsInPounds: 100 } }));
      wrapper = mount(<Results apiKey={'test'} />);
    });

    wrapper.update();
    await expect(wrapper.find('h1').first().text()).toEqual("You've saved £100");
  })
});