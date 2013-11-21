class ResourcesController < ApplicationController

  def index
  end

  def new
    @resource = Resource.find(params[:id])
  end

end
